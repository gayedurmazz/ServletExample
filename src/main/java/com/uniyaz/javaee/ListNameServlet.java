package com.uniyaz.javaee;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListNameServlet implements Servlet {
    List<Person> personList = new ArrayList<>();
    String ad;
    String soyad;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init metodu çalıştı");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig metodu çalıştı");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("sisteme giris yapildi");
        String tip = servletRequest.getParameter("tip");

        if (tip.equals("kaydet")){
            ad = servletRequest.getParameter("ad");
            System.out.println(ad);
            soyad = servletRequest.getParameter("soyad");
            System.out.println(soyad);
            Person person = new Person();
            person.setAd(ad);
            person.setSoyad(soyad);
            personList.add(person);
        }else if(tip.equals("listele")){
            String html;
            for (Person person : personList) {
                html = person.getAd() + " " + person.getSoyad();
                servletResponse.setCharacterEncoding("UTF-8");
                servletResponse.getWriter().write(html + "\n");
            }
        }
    }

    @Override
    public String getServletInfo() {
        System.out.println("ServletInfo metodu çalıştı");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroy metodu çalıştı");
    }
}
