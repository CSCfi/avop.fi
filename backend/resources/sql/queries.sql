-- :name create-visitor! :! :n
-- :doc creates a new visitor record
INSERT INTO visitors
(vastaajatunnus, taustatiedot, login_time)
VALUES (:vastaajatunnus, :taustatiedot, now());

-- :name get-visitor :? :1
-- :doc retrieve visitor for certan study right id
SELECT * FROM visitors
WHERE taustatiedot ->>'opiskeluoikeus' = :opiskeluoikeus_id
      AND taustatiedot ->> 'oppilaitos' = :oppilaitos_id;

-- :name get-mapping-by-domain :? :1
-- :doc get Haka to VIRTA organization mapping by domain
SELECT * FROM organization_mappings
WHERE domain = :domain;

-- :name get-visitors :? :n
SELECT * FROM visitors;