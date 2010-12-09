package com.dumbster.smtp.action;

import java.util.List;

import com.dumbster.smtp.MailMessage;
import com.dumbster.smtp.Response;
import com.dumbster.smtp.SmtpState;

public class DataEnd implements Action {

	@Override
	public String toString() {
		return ".";
	}

	public Response response(SmtpState smtpState, List<MailMessage> messages, MailMessage currentMessage) {
		if (SmtpState.DATA_HDR == smtpState || SmtpState.DATA_BODY == smtpState) {
			return new Response(250, "OK", SmtpState.QUIT);
		} else {
			return new Response(503, "Bad sequence of commands: " + this, smtpState);
		}
	}

}
