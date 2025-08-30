package com.chli.core.models;

import com.chli.core.services.CustomServiceForScore;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import com.chli.core.services.CustomServiceForScore;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(
        adaptables = {Resource.class, SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CustomLearnModel {

    @ValueMapValue
    private String myName;

    @ValueMapValue
    private Integer myAge;

    @ValueMapValue
    private Integer myScore;

    @OSGiService
    private CustomServiceForScore customServiceForScore;

    private String scoreCard;

    @PostConstruct
    protected void init() {
        if (customServiceForScore != null && myScore != null) {
            scoreCard = customServiceForScore.scoreCard(myScore);
        }
    }

    public String getMyName() {
        return myName != null ? myName.toUpperCase() : "";
    }

    public Integer getMyAge() {
        return myAge;
    }

    public Integer getMyScore() {
        return myScore;
    }

    public String getScoreCard() {
        return scoreCard;
    }
}
