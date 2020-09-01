ALTER TABLE organization_mappings ADD COLUMN type TEXT;

ALTER TABLE organization_mappings DROP CONSTRAINT organization_mappings_domain_key;

UPDATE organization_mappings SET type = 'avop'
WHERE domain IN ('arcada.fi','cou.fi','diak.fi','haaga-helia.fi','hamk.fi',
                 'humak.edu','humak.fi','jamk.fi','kamk.fi','kyamk.fi','lab.fi','lamk.fi',
                 'lapinamk.fi','laurea.fi','lpt.fi','mamk.fi','metropolia.fi','novia.fi',
                 'oamk.fi','pkamk.fi','puv.fi','saimia.fi','samk.fi','savonia.fi',
                 'seamk.fi','student.diak.fi','tamk.fi','turkuamk.fi','vamk.fi','xamk.fi');

UPDATE organization_mappings SET type = 'kandi'
WHERE domain IN ('aalto.fi','abo.fi','hanken.fi','helsinki.fi','jyu.fi',
                 'lut.fi','oulu.fi','tut.fi','uef.fi','ulapland.fi',
                 'uniarts.fi','uta.fi','utu.fi','uva.fi','uwasa.fi');

UPDATE organization_mappings SET type = 'kandi' WHERE domain = 'tuni.fi' AND code = '10122';

INSERT INTO organization_mappings (domain, code, type) VALUES ('tuni.fi', '02630', 'avop');