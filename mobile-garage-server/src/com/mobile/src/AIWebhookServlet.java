package com.mobile.src;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ai.api.GsonFactory;
import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import requests.AIWebhookRequest;

/**
 * Servlet implementation class AIWebhookServlet
 */
@WebServlet("/AIWebhookServlet")
/**
 * Basic web-hook servlet
 */
public class AIWebhookServlet extends HttpServlet {

  private static final String RESPONSE_CONTENT_TYPE = "application/json";

  private static final String RESPONSE_CHARACTER_ENCODING = "utf-8";

  private static final long serialVersionUID = 102831973239L;

  private final Gson gson = GsonFactory.getDefaultFactory().getGson();

  
  /**
   * Default constructor. 
   */
  public AIWebhookServlet() {
      // TODO Auto-generated constructor stub
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("From Google Assistant-------222");
	
		System.out.println(request.getQueryString());
		response.setContentType("text/html");
      PrintWriter printWriter  = response.getWriter();
      printWriter.println("<h1>Hello World, Welcome!!!</h1>");
	}
	
	
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
	  System.out.println("From Google Assistant-------");
	  
    Fulfillment output = new Fulfillment();

    //doWebhook(gson.fromJson(request.getReader(), AIWebhookRequest.class), output);

    response.setCharacterEncoding(RESPONSE_CHARACTER_ENCODING);
    response.setContentType(RESPONSE_CONTENT_TYPE);
    gson.toJson(output, response.getWriter());
  }

  /**
   * Web-hook processing method.
   * @param input Received request object 
   * @param output Response object. Should be filled in the method.
   */
  //protected abstract void doWebhook(AIWebhookRequest input, Fulfillment output);

  /*@Override
  protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
      String action = input.getResult().getAction();

      if(actionMap.containsKey(action)){
          Action botAction = actionMap.get(action);
          botAction.execute(input.getResult(), output);
      }
  } */
  
  /*@Override
  protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
      String action = input.getResult().getAction();

      if(action.equals("myAction")){
          // do something with the action
      }
  } */
  

}