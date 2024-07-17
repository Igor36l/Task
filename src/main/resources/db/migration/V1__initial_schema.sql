-- Create user_role table
CREATE TABLE user_role (
                           id        BIGINT                NOT NULL,
                           name     VARCHAR(64)           NOT NULL,
                           CONSTRAINT user_role_pkey PRIMARY KEY (id)
);

-- Create department table

CREATE TABLE department (
                            id        BIGINT                NOT NULL,
                            name     VARCHAR(64)           NOT NULL,
                            active   BOOLEAN DEFAULT FALSE NOT NULL,
                            CONSTRAINT department_pkey PRIMARY KEY (id)
);

-- Create user table
CREATE TABLE user (
                      id              BIGINT                NOT NULL,
                      login           VARCHAR(64)           NOT NULL,
                      password        VARCHAR(256)          NOT NULL,
                      full_name       VARCHAR(256)          NOT NULL,
                      role_id         BIGINT,
                      email           VARCHAR(128),
                      department_id   BIGINT,
                      birth_day       TIMESTAMP             NOT NULL,
                      active          BOOLEAN DEFAULT FALSE NOT NULL,
                      update_date     TIMESTAMP             NOT NULL,
                      CONSTRAINT user_pkey PRIMARY KEY (id),
                      CONSTRAINT fk_user_role_id FOREIGN KEY (role_id) REFERENCES user_role(id),
                      CONSTRAINT fk_user_department_id FOREIGN KEY (department_id) REFERENCES department(id)
);