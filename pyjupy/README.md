# Python + Jupyter class environment (Nix + direnv)

## Prerequisites

- Nix installed with flakes enabled.
- `direnv` installed.
- `nix-direnv` installed for best caching behavior.

## One-time setup for your shell

If not already done, hook `direnv` into your shell.

For zsh, add this to your `~/.zshrc`:

```sh
eval "$(direnv hook zsh)"
```

Reload shell:

```sh
source ~/.zshrc
```

## Enter the environment

From this folder, allow direnv:

```sh
direnv allow
```

After that, entering this directory auto-loads the environment.

## Start Jupyter

```sh
jupyter lab
```

## Included Python packages

- `ipython`, `ipykernel`, `jupyterlab`, `notebook`
- `numpy`, `pandas`, `scipy`, `sympy`
- `matplotlib`, `seaborn`, `plotly`
- `scikit-learn`, `requests`

Edit `flake.nix` to add or remove packages as classes require.
