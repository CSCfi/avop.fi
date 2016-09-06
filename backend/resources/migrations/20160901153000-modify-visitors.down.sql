-- Modify visitors
ALTER TABLE visitors ADD COLUMN opiskeluoikeus_id VARCHAR(100);
--;;

ALTER TABLE visitors ADD COLUMN oppilaitos_id VARCHAR(255);
--;;

ALTER TABLE visitors DROP COLUMN taustatiedot;
--;;

ALTER TABLE visitors RENAME COLUMN vastaajatunnus TO arvo_answers_hash;