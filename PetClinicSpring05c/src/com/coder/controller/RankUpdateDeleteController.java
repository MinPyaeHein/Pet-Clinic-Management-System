package com.coder.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.RankForm;
import com.coder.form.RankRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.servic.RankServic;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class RankUpdateDeleteController {
	@Autowired
	private RankServic rankServic;
	
	@RequestMapping("/rankUpdatePath")
	public String rankUpdateDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		RankRegisterForm rankRegisterForm=new RankRegisterForm();
		RankForm rankForm=new RankForm();
		String frmRankId=req.getParameter("frmRankId");
		rankForm.setRankId(frmRankId);
		rankRegisterForm.setRankForm(rankForm);
        modelMap.addAttribute("rankRegisterForm",rankRegisterForm);
		rankServic.preparRankUpdate(rankRegisterForm);
		return "rankUpdate";
	}
	
	@RequestMapping("/rankUpdateSubmitPath")
	public String rankUpdateSubmitDispatcher(@ModelAttribute("rankRegisterForm") RankRegisterForm rankRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	String cancle=req.getParameter("cancle");
		String update=req.getParameter("update");
		if(update!=null){
		rankServic.rankUpdate(rankRegisterForm);
		
     }
		this.rankServic.preparRankRegister(rankRegisterForm);
		 modelMap.addAttribute("rankRegisterForm",rankRegisterForm);
		 return "rankRegister";
	  }
	@RequestMapping("/rankDeletePath")
	public String rankDeleteDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		RankRegisterForm rankRegisterForm=new RankRegisterForm();
		RankForm rankForm=new RankForm();
		String frmRankId=req.getParameter("frmRankId");
		rankForm.setRankId(frmRankId);
		rankRegisterForm.setRankForm(rankForm);
       
		this.rankServic.rankDelete(rankRegisterForm);
		this.rankServic.preparRankRegister(rankRegisterForm);
		modelMap.addAttribute("rankRegisterForm",rankRegisterForm);
		return "rankRegister";
	}
	
}
