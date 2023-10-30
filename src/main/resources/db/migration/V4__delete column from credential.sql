ALTER TABLE credential DROP COLUMN userId;

ALTER TABLE users RENAME COLUMN credentialId TO credential_id;