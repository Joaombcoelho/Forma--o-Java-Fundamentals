📘 Sudoku em Java

Um jogo de Sudoku desenvolvido em Java para praticar Programação Orientada a Objetos (POO).
O projeto foi construído em etapas para facilitar o aprendizado e pode rodar tanto no console quanto futuramente em interface gráfica (Swing/JavaFX).

🚀 Funcionalidades

✅ Tabuleiro 9x9 dividido em blocos 3x3

✅ Escolha de dificuldade: fácil, médio, difícil

✅ Validação de jogadas (linha, coluna e bloco 3x3)

✅ Limite de 5 erros → derrota automática

✅ Contagem de tempo de jogo

✅ Pontuação baseada em tempo e erros

✅ Interface de console limpa e intuitiva

🔜 (Em desenvolvimento) Interface gráfica (Swing/JavaFX)

🏗️ Estrutura do Projeto
src/
 ├── model/
 │    ├── Board.java          # Representa o tabuleiro do Sudoku
 │    └── Difficulty.java     # Enum para dificuldades (FACIL, MEDIO, DIFICIL)
 │
 ├── service/
 │    ├── SudokuValidator.java # Regras de validação
 │    └── SudokuGenerator.java # Geração de tabuleiros por dificuldade
 │
 ├── main.java                # Ponto de entrada do jogo (console)
 └── SudokuGUI.java           # (Opcional) Interface gráfica com Swing

▶️ Como Rodar o Projeto

1. Compilar
javac -d bin src/**/*.java

2. Executar
java -cp bin main

🎮 Como Jogar (Console)

Escolha a dificuldade ao iniciar.

O jogo mostra o tabuleiro com células vazias representadas por ..

Insira uma jogada no formato:

linha coluna valor

ou

linha,coluna,valor

Exemplo:

1 2 3

→ insere o valor 3 na linha 1, coluna 2.

Você tem 5 tentativas erradas antes de perder.

O jogo termina quando o tabuleiro for completado corretamente.

📊 Sistema de Pontuação

Baseado no tempo total de jogo

Penalização de -50 pontos por erro

Fórmula:

Pontuação = 1000 - tempo_em_segundos - (erros * 50)

🖥️ Interface Gráfica (opcional)

Se preferir rodar o Sudoku com GUI (Swing):

java -cp bin SudokuGUI

A GUI contém:

Tabuleiro interativo 9x9

Botões de Novo Jogo e Verificar

Destaque para erros e células fixas

📚 Aprendizados

Este projeto cobre conceitos importantes de Java:

POO (classes, enums, encapsulamento)

Coleções (List, Arrays, Random)

Validação de regras de negócio

Interação com usuário via console

(Extra) GUI com Swing

✨ Futuras Melhorias

 Salvar e carregar partidas

 Sistema de dicas

 Animações visuais na GUI

 Ranking de jogadores

 Exportar/Importar tabuleiros personalizados

🔹 Desenvolvido para prática de Java e POO.
