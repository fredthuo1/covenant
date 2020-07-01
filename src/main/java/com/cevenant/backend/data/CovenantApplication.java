package com.cevenant.backend.data;

import com.nylas.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class CovenantApplication {

	public static void main(String[] args) throws IOException, RequestFailedException, AddressException {
		//SpringApplication.run(CovenantApplication.class, args);
		/*
			Start Application
			Sign Up/ Login
			Organization Dashboard

		*/
		NylasClient nylasClient = new NylasClient();
		NylasApplication application = nylasClient.application("apjl3ck8bwm6sjt72tbvnh4du","eotk65mpz66uco9pw33idfu86");
		HostedAuthentication authentication = application.hostedAuthentication();
		String hostedAuthUrl = authentication.urlBuilder()
				.redirectUri("http://google.com")
				.responseType("token")
				.scopes(Scope.EMAIL_DRAFTS, Scope.EMAIL_FOLDERS_AND_LABELS, Scope.EMAIL_METADATA, Scope.EMAIL_MODIFY, Scope.EMAIL_READ_ONLY, Scope.EMAIL_SEND, Scope.CALENDAR, Scope.CONTACTS)
				.loginHint("ftmrk9@umsystem.edu")
				.state("connected")
				.buildUrl();
		System.out.println(hostedAuthUrl);

		NylasClient client = new NylasClient();
		NylasAccount account = client.account("kMPvA6H3195Vcan69zlOhrE5y5ZYhn");
		Draft draft = new Draft();
		draft.setSubject("Covenant Confirmation Email");
		draft.setBody(hostedAuthUrl);
		draft.setTo(Arrays.asList(new NameEmail("My Nylas Friend", "ftmrk9@umsystem.edu")));

		account.drafts().send(draft);
	}
}
