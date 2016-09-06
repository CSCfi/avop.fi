ALTER TABLE visitors DROP COLUMN opiskeluoikeus_id;
--;;
ALTER TABLE visitors DROP COLUMN oppilaitos_id;
--;;
ALTER TABLE visitors ADD COLUMN taustatiedot JSON;
--;;
ALTER TABLE visitors RENAME COLUMN arvo_answers_hash TO vastaajatunnus;