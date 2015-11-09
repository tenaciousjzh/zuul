# Zuul
For those unfamiliar with the epic sci-fi movie, Ghostbusters,
Zuul was the Gatekeeper to the world of ghosts. Like the movie, Zuul
is a microservice that acts as a gatekeeper protecting private services
behind it. Zuul will provide authentication, session management, and authorization.

# Features
## Authentication
- For the initial release, Zuul will support authentication against a SQL backend, and LDAP. Zuul is built with extensibitlity in mind though. By implementing the Authentictor protocol, you can easily connect Zuul with a different data source.
- Zuul will automatically encrypt passwords with a one-way hashing algorithm. By default, they will be encrypted with bcrypt but that can be modified to use MD5 or SHA.

## Session Management
- Zuul will offload session management from your application enabling you to scale your microservices much easier.
- Zuul's API will provide the ability to configure the session token TTL (Time To Live) to update any time a request is made with it or can simply let the session time out automatically from the first successful authentication. By default, the session TTL will be set for 1200 seconds (20 min), but can be configured to a different value.

## Authorization
- Zuul performs role based authentication on RESTFul endpoints.
- Roles and endpoints can be configured before start up in an EDN formatted file, in the database, or at runtime with a RESTful API call. To make the API call, you must first set up a public/private key that can be used by Zuul and the authorized client to prevent unwanted access. Zull will provide utilities to generate a public key that can be used by the client.
- Zuul also has an API gateway mode. When enabled, Zuul will authenticate and authorize
a RESTful request. If authorized, the request will forward to the request to the intended
endpoint.

## License
MIT

Copyright © 2015 Jared Holmberg
