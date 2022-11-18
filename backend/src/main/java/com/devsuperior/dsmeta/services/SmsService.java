package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.repositories.SalesRepositories;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private SalesRepositories saleRepo;

	public void sendSms(Long saleId) {
		Sales sale = saleRepo.findById(saleId).get();

		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();

		String msg = "O vendedor: " + sale.getSellerName()
				+ " vendeu R$" + sale.getAmount()
				+ " no mês " + date;

		Twilio.init(twilioSid, twilioKey);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		Message message = Message.creator(to, from, msg).create();
		System.out.println(message.getSid());
	}
}
