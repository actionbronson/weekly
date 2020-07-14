package org.weekly.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.weekly.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class WeeklyUserFactoryTest {

    @Test
    public void testGoogleCreation() {
        WeeklyUserFactory factory = new WeeklyUserFactory();
        User u = factory.from(createGoogleUser(), "google");
        Assert.assertEquals(u.getId().getProvider(), "google");
        Assert.assertEquals(u.getName(), "Roger Waters");
        Assert.assertEquals(u.getFirstName(), "Roger");
        Assert.assertEquals(u.getLastName(), "Waters");
        Assert.assertNotNull(u.getPicture());
    }

    @Test
    public void testFacebookCreation() {
        WeeklyUserFactory factory = new WeeklyUserFactory();
        User u = factory.from(createFacebookUser(), "facebook");
        Assert.assertEquals(u.getId().getProvider(), "facebook");
        Assert.assertEquals(u.getName(), "Roger Waters");
        Assert.assertEquals(u.getFirstName(), "Roger");
        Assert.assertEquals(u.getLastName(), "Waters");
        Assert.assertNotNull(u.getPicture());
    }

    private OAuth2User createGoogleUser() {
        return new OAuth2User() {

            @Override
            public String getName() {
                return "Roger Waters";
            }

            @Override
            public Map<String, Object> getAttributes() {
                return Map.of("given_name", "Roger",
                        "family_name", "Waters",
                        "name", "Roger Waters",
                        "picture", "http://pf.com/horseface.jpg");
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_USER";
                    }
                });
            }
        };
    }

    private OAuth2User createFacebookUser() {
        return new OAuth2User() {

            @Override
            public String getName() {
                return "Roger Waters";
            }

            @Override
            public Map<String, Object> getAttributes() {
                return Map.of("first_name", "Roger",
                        "last_name", "Waters",
                        "name", "Roger Waters",
                        "picture", Map.of("data", Map.of("url","http://pf.com/horseface.jpg")));
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_USER";
                    }
                });
            }
        };
    }
}
