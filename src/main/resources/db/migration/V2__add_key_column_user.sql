ALTER TABLE users."user" ADD COLUMN key VARCHAR(36);
CREATE UNIQUE INDEX ux_user_key ON users."user" (key);