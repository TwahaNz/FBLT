package FBLT.domain.temporarylogin;

import FBLT.domain.user.User;

/**
 * This class is responsible for our temporary login feature
 */
public class TemporaryLogin {

    private User user;
    private String code;
    private String id;
    private String timestamp;

    private TemporaryLogin() {}

    public TemporaryLogin(Builder builder) {
        this.code = builder.code;
        this.user = builder.user;
        this.id = builder.id;
        this.timestamp = builder.timestamp;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public static class Builder
    {
        private User user;
        private String code;
        private String id;
        private String timestamp;

        public Builder timestamp(String timestamp){
            this.timestamp = timestamp;
            return this;
        }

        public Builder user(User user)
        {
            this.user = user;
            return this;
        }

        public Builder code(String code)
        {
            this.code = code;
            return this;
        }

        public Builder id(String id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(TemporaryLogin temporaryLogin)
        {
            this.code = temporaryLogin.code;
            this.user = temporaryLogin.user;
            this.id = temporaryLogin.id;
            this.timestamp = temporaryLogin.timestamp;

            return this;
        }

        public TemporaryLogin build()
        {
            return new TemporaryLogin(this);
        }
    }
}
