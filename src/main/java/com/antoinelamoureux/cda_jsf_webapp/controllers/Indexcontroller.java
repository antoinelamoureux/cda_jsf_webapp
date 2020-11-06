/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antoinelamoureux.cda_jsf_webapp.controllers;

import com.antoinelamoureux.cda_jsf_webapp.business.NewsFacade;
import com.antoinelamoureux.cda_jsf_webapp.business.TagFacade;
import com.antoinelamoureux.cda_jsf_webapp.business.ThemeFacade;
import com.antoinelamoureux.cda_jsf_webapp.entities.News;
import com.antoinelamoureux.cda_jsf_webapp.entities.Tag;
import com.antoinelamoureux.cda_jsf_webapp.entities.Theme;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author admin
 */
@Named(value = "indexcontroller")
@SessionScoped
public class Indexcontroller implements Serializable {

    @EJB
    NewsFacade newsFacade;
    @EJB
    ThemeFacade themeFacade;
    @EJB
    TagFacade tagFacade;

    News currentNews;
    Theme currentTheme;
    Tag currentTag;

    List<News> news;
    List<Theme> themes;
    List<Tag> tags;

    List<News> newsResults;

    public Indexcontroller() {
        news = null;
        themes = null;
        tags = null;
    }

    public String getNewsDetails(int id) {
        // UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        // UIComponent component = view.findComponent("newsDetails");

        // String id = (String) component.getAttributes().get("id");
        currentNews = getNewsFacade().find(id);

        return "details";
    }

    public String getResults() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String title = request.getParameter("searchForm:search");

        newsResults = getNewsFacade().getEntityManager()
                .createNamedQuery("News.searchByTitleLike")
                .setParameter("title", "%" + title + "%")
                .getResultList();

        return "results";
    }
    
    public String getNewsForTag(Tag tag) {
        currentTag = tag;
        news = (List<News>) currentTag.getNewsCollection();
        
        return "index";
    }
    
    public String getNewsForTheme(Theme theme) {
        currentTheme = theme;
        news = (List<News>) currentTheme.getNewsCollection();
        
        return "index";
    }
    
    public void clearAll() {
        currentTheme = null;
        currentTag = null;
        news = null;
        news = this.getNews();
    }

    public NewsFacade getNewsFacade() {
        return newsFacade;
    }

    public void setNewsFacade(NewsFacade newsFacade) {
        this.newsFacade = newsFacade;
    }

    public ThemeFacade getThemeFacade() {
        return themeFacade;
    }

    public void setThemeFacade(ThemeFacade themeFacade) {
        this.themeFacade = themeFacade;
    }

    public TagFacade getTagFacade() {
        return tagFacade;
    }

    public void setTagFacade(TagFacade tagFacade) {
        this.tagFacade = tagFacade;
    }

    public News getCurrentNews() {
        return currentNews;
    }

    public void setCurrentNews(News currentNews) {
        this.currentNews = currentNews;
    }

    public Theme getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }

    public Tag getCurrentTag() {
        return currentTag;
    }

    public void setCurrentTag(Tag currentTag) {
        this.currentTag = currentTag;
    }

    public List<News> getNews() {
        if (news == null) {
            news = getNewsFacade().findAll();
        }
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Theme> getThemes() {
        if (themes == null) {
            themes = getThemeFacade().findAll();
        }
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Tag> getTags() {
        if (tags == null) {
            tags = getTagFacade().findAll();
        }
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<News> getNewsResults() {
        return newsResults;
    }

    public void setNewsResults(List<News> newsResults) {
        this.newsResults = newsResults;
    }

}
