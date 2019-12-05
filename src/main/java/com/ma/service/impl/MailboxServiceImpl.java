package com.ma.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ma.service.MailboxService;
@Service
@Transactional
public class MailboxServiceImpl implements MailboxService{

	@Autowired
	private MailboxService mailboxService;
	
	@Override
	public String html(String code) {
		String html = "sdfsdfsdaf<br/>"+ 
				"这封邮件是由【柒晓白网络科技】发送的。<br/>"+
				"dsfdsfsdsdfsdfsdfsdfsdfsdfsdfsdfsdafsdf使用这个地址。<br/>"+
				"sdfsdfsdfdsfsdaf声明<br/>"+
				"请将下面的验证码输入到提示框即可：<h3 style='color:red;'>" + code + "</h3><br/>";
				return html;
	}

	@Override
	public MimeMessage creatMimeMessage(Session session, String sendMail, String receiveMail, String html)
			throws MessagingException, IOException {
		// 1、创建一封邮件对象
		MimeMessage message = new MimeMessage(session);
		// 2、From：发件人
		message.setFrom(new InternetAddress(sendMail, "发件人昵称", "UTF-8"));
		// 3、To:收件人（可以增加多个收件人：抄送或者密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "张三", "UTF-8"));
		// 4、Subject:邮件主题
		message.setSubject("邮箱验证","UTF-8");
		// 5、Content:邮件正文（可以使用Html标签）
		message.setContent(html,"text/html;charset=UTF-8");
		// 6、设置发送时间
		message.setSentDate(new Date());
		// 7、保存设置
		message.saveChanges();
		// 8、将该邮件保存在本地
		//OutputStream out = new FileOutputStream("D://MyEmail" + UUID.randomUUID().toString() + ".eml");
		//message.writeTo(out);
		//out.flush();
		//out.close();
		return message;
	}

	@Override
	 public  String getRandom() {
		String[] letters = new String[] {
				"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m",
				"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
				"0","1","2","3","4","5","6","7","8","9"};
		String code ="";
		for (int i = 0; i < 6; i++) {
			code = code + letters[(int)Math.floor(Math.random()*letters.length)];
		}
		return code;
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp, String emailAccount, String emailPassword,
			String emailSMTPHost, String receiveMailAccount) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("邮箱发送功能");
		try {
			//JavaMailUtil.receiveMailAccount = email; // 给用户输入的邮箱发送邮件
 
			// 1、创建参数配置，用于连接邮箱服务器的参数配置
			Properties props = new Properties();
			// 开启debug调试
			props.setProperty("mail.debug", "true");
			// 发送服务器需要身份验证
			props.setProperty("mail.smtp.auth", "true");
			// 设置右键服务器的主机名
			props.setProperty("mail.host", emailSMTPHost);
			// 发送邮件协议名称
			props.setProperty("mail.transport.protocol", "smtp");
 
			// 2、根据配置创建会话对象，用于和邮件服务器交互
			Session session = Session.getInstance(props);
			// 设置debug，可以查看详细的发送log
			session.setDebug(true);
			// 3、创建一封邮件
			String code = mailboxService.getRandom();
			System.out.println("邮箱验证码：" + code);
			String html = mailboxService.html(code);
			MimeMessage message = mailboxService.creatMimeMessage(session, emailAccount,
					receiveMailAccount, html);
 
			// 4、根据session获取邮件传输对象
			Transport transport = session.getTransport();
			// 5、使用邮箱账号和密码连接邮箱服务器emailAccount必须与message中的发件人邮箱一致，否则报错
			transport.connect(emailAccount, emailPassword);
			// 6、发送邮件,发送所有收件人地址
			transport.sendMessage(message, message.getAllRecipients());
			// 7、关闭连接
			transport.close();
			//  写入session			
			req.getSession().setAttribute("code", code);
			System.out.println(req.getSession().getAttribute("code"));
			System.out.println("写入成功");
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "邮件发送失败");
		}
		
	}

}
