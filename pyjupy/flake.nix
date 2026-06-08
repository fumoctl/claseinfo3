{
  description = "Python + Jupyter dev environment for university classes";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          inherit system;
          config.allowUnfree = true;
        };

        python = pkgs.python312;
        pythonEnv = python.withPackages (ps: with ps; [
          ipython
          ipykernel
          jupyterlab
          notebook
          numpy
          pandas
          scipy
          sympy
          matplotlib
          seaborn
          scikit-learn
          plotly
          requests
        ]);
      in {
        devShells.default = pkgs.mkShell {
          packages = [
            pythonEnv
            pkgs.git
          ];

          shellHook = ''
            export PIP_DISABLE_PIP_VERSION_CHECK=1
            export PYTHONDONTWRITEBYTECODE=1
            export MPLBACKEND=Agg

            echo "Python environment ready"
            python --version
            echo "Jupyter Lab available: run 'jupyter lab'"
          '';
        };
      }
    );
}
