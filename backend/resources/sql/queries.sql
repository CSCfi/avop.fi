-- :name create-visitor! :! :n
-- :doc creates a new visitor record
INSERT INTO visitors
(vastaajatunnus, taustatiedot, login_time)
SELECT :vastaajatunnus, :taustatiedot, now()
WHERE NOT EXISTS (SELECT 1 FROM visitors WHERE vastaajatunnus = :vastaajatunnus);

-- :name get-visitor :? :1
-- :doc retrieve visitor for certain study right id
SELECT * FROM visitors
WHERE taustatiedot ->> 'opiskeluoikeus' = :opiskeluoikeus_id
  AND taustatiedot ->> 'oppilaitos' = :oppilaitos_id
LIMIT 1;

-- :name get-rekry-visitor :? :1
SELECT * FROM visitors
WHERE taustatiedot ->> 'oppilaitos' = :oppilaitos
--~(if (:employeeNumber params) "AND taustatiedot ->> 'employeeNumber' = :employeeNumber")
--~(if (:eppn params) "AND taustatiedot ->> 'eppn' = :eppn")
  AND (taustatiedot ->> 'vuosi')::int = :vuosi
LIMIT 1;

-- :name get-mapping-by-domain :? :1
-- :doc get Haka to VIRTA organization mapping by domain
SELECT * FROM organization_mappings
WHERE domain = :domain AND type = :type;

-- :name get-mappings-for-rekry :? :*
SELECT * FROM organization_mappings
WHERE domain = :domain;

-- :name get-visitors :? :*
SELECT * FROM visitors;

-- :name get-opiskeluoikeus :? :*
SELECT vastaajatunnus, taustatiedot->>'opiskeluoikeus' AS opiskeluoikeus
FROM visitors
WHERE taustatiedot ->>'opiskeluoikeus' IS NOT NULl
AND taustatiedot->>'oppilaitos' IN (:v*:oppilaitokset);