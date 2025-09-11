package com.adobe.aem.tutorial.core.Services.Impl;


import com.adobe.aem.tutorial.core.Services.CustomServiceForScore;
import org.osgi.service.component.annotations.Component;

@Component(service = CustomServiceForScore.class)
public class CustomServiceForScoreImpl implements CustomServiceForScore {

    @Override
    public String scoreCard(int score) {
        if(score >=90) return "A";
        else if(score>70) return "B";
        else return "F";
    }
}