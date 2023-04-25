package top.novashen.ems.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Locale;

import static javax.swing.JComponent.getDefaultLocale;

public class LocaleResolver implements org.springframework.web.servlet.LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale defaultLocale = getDefaultLocale();
        String lang = request.getParameter("lang");
        System.out.println(lang);
        if ("zh-CN".equals(lang)) {
            return Locale.CHINA;
        } else if ("en-US".equals(lang)) {
            return Locale.US;
        } else {
            return defaultLocale;
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
