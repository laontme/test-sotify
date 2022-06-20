[![kotlin](https://img.shields.io/badge/kotlin_inside-7f52ff?style=flat)](https://go.dev/)
[![license](https://img.shields.io/badge/mit_license-black?style=flat)](/LICENSE.md)
[![love](https://img.shields.io/badge/made_with_❤-ff3053?style=flat)](https://laont.me/)
[![ci](https://img.shields.io/badge/ci_passed-42f5b3?style=flat)](https://laont.me/)
# sotify `sleep notifications`

## usage

### commands
| command   | description             | permission |
|-----------|-------------------------|------------|
| `/sotify` | reloading configuration | `sotify`   |

### perms
| permission | allows                  | default  |
|------------|-------------------------|----------|
| `sotify`   | reloading configuration | operator |

### config
```yaml
messages:
  player-enter-bed: <dark_aqua>[Sotify] <player> is now sleeping (<sleeping>/<needed>, <more> more needed to skip)
  player-leave-bed: <dark_aqua>[Sotify] <player> got out of bed (<sleeping>/<needed>, <more> more needed to skip)
```
This plugin uses the MiniMessage format. You can use any formatting from MiniMessage but `<player>`, `<sleeping>`, `<needed>` and `<more>` is special placeholders. You can remove them but not change

Changing `/sotify` command message is not possible because it is not visible in normal approach

## author
[laont.me](https://laont.me) and [stanislav@laont.me](mailto:stanislav@laont.me)

## license
This repository is licensed under [MIT license](/LICENSE.md). You can freely copy, modify and distribute code, but with notice about license and copyright