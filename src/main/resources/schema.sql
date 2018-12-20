-- H2データベースにテーブルをつくる
CREATE TABLE todo(
  id IDENTITY,
  body TEXT NOT NULL,
  done BOOLEAN NOT NULL DEFAULT FALSE
);
