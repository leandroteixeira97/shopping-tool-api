ALTER TABLE users ADD COLUMN expired boolean NOT NULL DEFAULT false;

ALTER TABLE credential DROP COLUMN expired;