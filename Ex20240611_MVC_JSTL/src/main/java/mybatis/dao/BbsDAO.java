package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.BbsVO;

public class BbsDAO {

	public static int getCount(String bname) {
		int count = 0;

		SqlSession ss = FactoryService.getFactory().openSession();
		
		count = ss.selectOne("bbs.count",bname);

		ss.close();
		
		
		return count;
	}
	
	public static BbsVO getView(/*String bname,*/ String b_idx) {
		BbsVO bvo = null;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
//		HashMap<String, String> b_map = new HashMap<>();
		
//		b_map.put("bname", bname);
//		b_map.put("b_idx", b_idx);
		
		bvo = ss.selectOne("bbs.view",b_idx);
		
		
		ss.close();
		
		return bvo;
	}
	
	public static int hitInc(String b_idx) {
		
		SqlSession ss = FactoryService.getFactory().openSession();

		int chk = ss.update("bbs.hitInc",b_idx);
		
		if(chk > 0) {
			ss.commit();
		} else {
			ss.rollback();
		}
		
		ss.close();
		
		return chk;
	}
	
	public static BbsVO[] getList(String bname, int begin, int end) {
		BbsVO[] b_ar = null;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		HashMap<String, String> b_map = new HashMap<>();
		
		b_map.put("bname", bname);
		b_map.put("begin", String.valueOf(begin));
		b_map.put("end", String.valueOf(end));
		
		List<BbsVO> b_list = ss.selectList("bbs.list",b_map);
		
		if(b_list != null && b_list.size()>0) {
			b_ar = new BbsVO[b_list.size()];
			
			b_list.toArray(b_ar);
		}
		ss.close();
		
		return b_ar;
	}
	
public static int add(String title, String writer, String content, String fname, String oname, String ip, String b_name) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		HashMap<String, String> b_map = new HashMap<>();
		
		b_map.put("subject", title);
		b_map.put("writer", writer);
		b_map.put("content", content);
		b_map.put("file_name", fname);
		b_map.put("ori_name", oname);
		b_map.put("ip", ip);
		b_map.put("bname", b_name);
		
		int chk = ss.insert("bbs.add",b_map);
		
		if(chk == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		
		ss.close();
		
		return chk;
		
	}
	
public static int addComm(String writer, String content, String pwd, String ip, String b_idx) {
	
	SqlSession ss = FactoryService.getFactory().openSession();
	
	HashMap<String, String> b_map = new HashMap<>();
	
	b_map.put("writer", writer);
	b_map.put("content", content);
	b_map.put("ip", ip);
	b_map.put("b_idx", b_idx);
	
	int chk = ss.insert("comment.addComm",b_map);
	
	if(chk == 1) {
		ss.commit();
	} else {
		ss.rollback();
	}
	
	ss.close();
	
	return chk;
	
}


	
	// 원글 수정
	
	public static int edit (String b_idx, String subject, String content,
							String fname, String oname, String ip) {
		HashMap<String, String> e_map = new HashMap<>();
		e_map.put("b_idx", b_idx);
		e_map.put("subject", subject);
		e_map.put("content", content);
		if(fname != null) {
			e_map.put("fname", fname);
			e_map.put("oname", oname);
		}
		e_map.put("ip", ip);
		
		SqlSession ss = FactoryService.getFactory().openSession();
		int chk = ss.update("bbs.edit",e_map);
		if(chk>0) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return chk;
		
		
	}
								
	
	
	public static int delBbs(String b_idx) {
		
		SqlSession ss = FactoryService.getFactory().openSession();

		int chk = ss.update("bbs.delBbs",b_idx);
		
		if(chk > 0) {
			ss.commit();
		} else {
			ss.rollback();
		}
		
		ss.close();
		
		return chk;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}