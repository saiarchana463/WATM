package com.atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ATM extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedHashSet<Account> customerList = new LinkedHashSet<>();
		boolean sameUser = true,exitOrEntry = true,validUser=true;
		String accountNo = req.getParameter("accountNo");
//		PrintWriter out = res.getWriter();
//		out.print("Account No : "+accountNo);
		customerList = Validation.userObjectsCreation(customerList);
		sameUser = true;
		Account accountObj	 = Validation.returnUserObject(customerList,accountNo);
		if(validUser && sameUser && accountObj != null) {
			 while(sameUser) {
					 Operation.operation(accountNo,br,accountObj);
					 customerList.add(accountObj);
					 System.out.println("Do you want to continue (yes/no):");
					 sameUser = br.readLine().equalsIgnoreCase("yes");
				} 
		 }
		
	}

}
