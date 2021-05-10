# Repositoryn sisältö ja rakenne
* **Frontend** - avop.fi käyttöliittymätoteutus
* **Backend** - avop.fi backend
* **ansible** - scripts for provisioning dev, test and production machines
* **containers** - contains docker and vagrant files providing isolated development environments

## UI ylikirjoitetut riippuvuudet
    "run-parallel": "^1.1.10", Mahdollistaa kääntämisen vanhemmalla node versiolla (jenkins)
    "lodash": "^4.17.21", Korjaa yleisen kriittisen haavoittuvuuden useissa kirjastoissa
    "y18n": "4.0.3", Korjaa kriittisen haavoittuvuuden react-scripts ja node-saas
    "ua-parser-js": "^0.7.28", Korjaa kriittisen haavoittuvuuden vanhoissa react-interpolate-component ja react-translate-component kirjastoissa joista pitäisi luopua
    "hosted-git-info": "2.8.9" Korjaa keskisuuren haavoittuvuuden react-scripts

