{
  description = "Java university dev environment with Nix + direnv";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs { inherit system; };
      in {
        devShells.default = pkgs.mkShell {
          packages = with pkgs; [
            jdk21
            maven
            gradle
            groovy
            ant

            # LSP and common Java helpers
            jdt-language-server
            google-java-format
            checkstyle
            lombok

            # Nice-to-have CLI tools for coursework
            git
            jq
            tree
            unzip
          ];

          JAVA_HOME = "${pkgs.jdk21}";

          shellHook = ''
            export PATH="$JAVA_HOME/bin:$PATH"
            echo "Java dev shell ready"
            echo "java:   $(java -version 2>&1 | head -n 1)"
            echo "maven:  $(mvn -v | head -n 1)"
            echo "gradle: $(gradle --version | head -n 1)"
          '';
        };
      });
}
