package org.weekly.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.weekly.model.User;
import org.weekly.model.UserId;

import java.util.Map;

import static java.lang.String.format;

@Component
public class WeeklyUserFactory {

    public static final String FACEBOOK = "facebook";
    public static final String GOOGLE = "google";

    public User fromFacebook(OAuth2User user) {
        Map<String, Map<String,Object>> picture = user.getAttribute("picture");
        Map<String,Object> pictureData = picture.get("data");
        String pictureUrl = (String) pictureData.get("url");
        return new User()
                .firstName(user.getAttribute("first_name"))
                .lastName(user.getAttribute("last_name"))
                .name(user.getAttribute("name"))
                .picture(pictureUrl)
                .id(new UserId().email(user.getAttribute("email")).provider(FACEBOOK));
    }

    public User fromGoogle(OAuth2User user) {
        String pictureUrl = user.getAttribute("picture");
        return new User()
                .firstName(user.getAttribute("given_name"))
                .lastName(user.getAttribute("family_name"))
                .name(user.getAttribute("name"))
                .picture(pictureUrl)
                .id(new UserId().email(user.getAttribute("email")).provider(GOOGLE));
    }

    public User from(OAuth2User user, String provider) {
        switch (provider.toLowerCase()) {
            case FACEBOOK:
                return fromFacebook(user);
            case GOOGLE:
                return fromGoogle(user);
            default:
                throw new UnsupportedOperationException(format("Cannot convert from provider: '%s'", provider));
        }
    }

    public User current() {
        SecurityContext context = SecurityContextHolder.getContext();
        OAuth2AuthenticationToken auth = (OAuth2AuthenticationToken) context.getAuthentication();
        OAuth2User user = auth.getPrincipal();
        return from(user, auth.getAuthorizedClientRegistrationId());
    }

}
