-- Modify visitors
ALTER TABLE visitors ADD COLUMN opiskeluoikeus_id VARCHAR(100);
--;;

ALTER TABLE visitors ADD COLUMN oppilaitos_id VARCHAR(255);
--;;

UPDATE visitors SET opiskeluoikeus_id=taustatiedot::json->'opiskeluoikeus', oppilaitos_id=taustatiedot::json->'oppilaitos';
--;;

ALTER TABLE visitors DROP COLUMN taustatiedot;
--;;

ALTER TABLE visitors RENAME COLUMN vastaajatunnus TO arvo_answer_hash;
