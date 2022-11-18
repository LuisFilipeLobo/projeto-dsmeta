package com.devsuperior.dsmeta.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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

	public void sendSms() {
		Twilio.init(twilioSid, twilioKey);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		Message message = Message.creator(to, from, "Testando envio de SMS").create();
		System.out.println(message.getSid());
	}
}
