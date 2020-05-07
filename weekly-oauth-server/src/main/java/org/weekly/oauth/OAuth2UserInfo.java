package org.weekly.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.AuthProvider;
import java.util.Map;

public abstract class OAuth2UserInfo {
    protected Map<String, Object> attributes;

    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getImageUrl();

    public static class OAuth2UserInfoFactory {
        private static final Logger logger = LoggerFactory.getLogger(OAuth2UserInfoFactory.class);

        public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
            logger.info(attributes.toString());
            return null;
        }
    }
}
