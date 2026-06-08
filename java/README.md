# Java Uni Dev Environment (Nix + direnv)

This folder now has a reproducible Java development environment using Nix Flakes and direnv.

## Included tools

- JDK 21 (full JDK, Swing included)
- Maven
- Gradle
- Ant
- jdt-language-server
- google-java-format
- Checkstyle
- Lombok
- git, jq, tree, unzip

## First-time setup

1. Ensure you have Nix with flakes enabled.
2. Install direnv and hook it into your shell.
3. (Recommended) install nix-direnv.
4. In this folder, run:

```bash
direnv allow
```

After that, entering this directory automatically loads the Java dev shell.

## Manual entry (without direnv)

```bash
nix develop
```

## Notes

- Swing is part of the standard JDK, so no extra Swing package is needed.
- If your class requires another tool (e.g., PostgreSQL, Node, Python), it can be added to `flake.nix` quickly.
