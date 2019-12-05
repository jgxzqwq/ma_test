package com.ma.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface MailboxService {

	
	//  返回页面Html携带的6位随机码
	public String html(String code);
	/**
	 *  创建一封邮件(发件人、收件人、邮件内容)
	 * @param session
	 * @param sendMail
	 * @param receiveMail
	 * @param html
	 * @return
	 * @throws MessagingException
	 * @throws IOException 
	 * cc:抄送-
	 * Bcc:密送
	 * To:发送
	 */
	public MimeMessage creatMimeMessage(Session session,String sendMail,String receiveMail,String html) throws MessagingException, IOException;
	public String getRandom();
	public void doPost(HttpServletRequest req, HttpServletResponse resp,String emailAccount,String emailPassword,String emailSMTPHost,String receiveMailAccount) throws ServletException, IOException;
}
