---
spec_id: desktop-ux-adaptation
source: manual
source_ref: dictated in chat, 2026-08-18
fetched_at: 2026-08-18
fetched_by: /spec-new
---

# Story: Adaptación de UX para Desktop

<!--
RAW INTAKE — DO NOT EDIT AFTER FETCH

This file preserves the source as it arrived, so future readers can
audit what /spec-plan worked from. /spec-plan reads this and produces
proposal.md; story.md is append-only thereafter.
-->

## Metadata

| Field | Value |
|-------|-------|
| Type | story |
| Priority | |
| Created | 2026-08-18 |

## Description

Como usuario de la aplicación en un dispositivo Desktop, quiero que las interacciones de la aplicación estén adaptadas al uso de mouse, teclado y otros controles propios de Desktop, para poder utilizar la aplicación de forma natural y eficiente sin depender de gestos táctiles propios de móviles y tablets.

### Ejemplos de adaptación

| Móvil/Tablet | Desktop |
|---|---|
| Swipe to refresh | Botón Refresh + shortcut |
| Long press | Right click / context menu |
| Tap | Mouse click |
| Touch gesture | Mouse/trackpad |
| FAB | Toolbar/action |
| Bottom sheet | Dialog/popover/menu según contexto |
| Back gesture | Esc / navegación |
| Touch selection | Mouse + keyboard |
| — | Hover |
| — | Keyboard shortcuts |
| — | Tooltips |
| — | Focus navigation |

### Fuera de alcance

- Cambiar la lógica de negocio.
- Crear funcionalidades exclusivas de Desktop que no tengan equivalente funcional en móvil.
- Rediseñar completamente la aplicación.
- Eliminar los gestos existentes en móvil/tablet.
- Crear una implementación independiente de la aplicación para Desktop.

### Resultado esperado

El usuario debe percibir la misma aplicación y funcionalidades en todas las plataformas, pero con interacciones que se sientan naturales para el dispositivo que está utilizando.

## Acceptance criteria (as written in source)

- La experiencia actual de móviles y tablets no debe modificarse ni degradarse.
- Las interacciones basadas exclusivamente en gestos táctiles deben disponer de una alternativa apropiada para Desktop.
- Swipe to refresh debe sustituirse o complementarse en Desktop con una acción de actualización accesible mediante:
  - botón de refresh;
  - shortcut de teclado cuando corresponda.
- Las acciones que actualmente utilizan long press deben disponer de una alternativa mediante click derecho/context menu cuando sea apropiado.
- Las acciones principales deben poder ejecutarse mediante mouse.
- Las acciones relevantes deben poder ejecutarse mediante teclado cuando sea apropiado.
- Los elementos interactivos de Desktop deben proporcionar estados adecuados de:
  - hover;
  - pressed;
  - focused;
  - disabled.
- Los elementos que requieran explicación adicional deben disponer de tooltips en Desktop.
- Los componentes que utilizan FAB o acciones flotantes en móvil deben evaluarse para determinar si en Desktop deben presentarse como acciones de toolbar, menú u otro patrón apropiado.
- La navegación debe adaptarse a Desktop cuando el patrón utilizado actualmente esté orientado a pantallas táctiles.
- Los diálogos, menús y acciones secundarias deben poder manejarse con teclado, incluyendo Esc para cancelar/cerrar cuando corresponda.
- La navegación mediante teclado debe respetar un orden lógico de foco.
- Las acciones que permitan selección múltiple deben soportar los patrones habituales de Desktop cuando corresponda, como Ctrl/Cmd + Click.
- No se deben introducir comportamientos específicos de Desktop en la capa de lógica de negocio cuando puedan resolverse mediante componentes o abstracciones de UI compartidas.
- La solución debe mantener la arquitectura KMP/Compose Multiplatform, reutilizando la lógica y componentes compartidos siempre que sea posible.
- No se requieren cambios funcionales en las operaciones de negocio; el objetivo de esta historia es adaptar los mecanismos de interacción y presentación para Desktop.

## Comments / discussion

(none — file/manual/url intake, no comment thread)

## Attachments

-

## Links

-
