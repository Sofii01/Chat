### **Descripción general**

Este proyecto consiste en el desarrollo de una API backend para un **sistema de chat en tiempo real**, donde múltiples usuarios pueden intercambiar mensajes instantáneamente mediante **WebSockets**. El objetivo no es solo implementar la funcionalidad del chat, sino también **estructurar el sistema con una arquitectura hexagonal** (Ports & Adapters) y aplicar el **patrón Command** para gestionar las acciones de negocio como el envío y recuperación de mensajes.

El proyecto **no incluye autenticación**, centrándose en la lógica de mensajería, el diseño limpio y la escalabilidad de la aplicación.


###  **Objetivos del proyecto**

- Implementar comunicación en tiempo real usando **Spring WebSocket + STOMP**
- Aplicar **arquitectura hexagonal** para separar dominio, aplicación e infraestructura
- Utilizar el **patrón Command** para encapsular y desacoplar los casos de uso
- Persistir los mensajes usando **JPA (MySQL)**
- Exponer también endpoints REST para consultar historial de mensajes
- Documentar la API con **Swagger (OpenAPI)** y facilitar el despliegue con **Docker**