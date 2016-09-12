-- Modify visitors
ALTER TABLE visitors ADD COLUMN taustatiedot JSON;
--;;

UPDATE visitors SET taustatiedot=json_build_object('opiskeluoikeus', opiskeluoikeus_id, 'oppilaitos', oppilaitos_id);
--;;

ALTER TABLE visitors DROP COLUMN opiskeluoikeus_id;
--;;

ALTER TABLE visitors DROP COLUMN oppilaitos_id;
--;;

ALTER TABLE visitors RENAME COLUMN arvo_answer_hash TO vastaajatunnus;
