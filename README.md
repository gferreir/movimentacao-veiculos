# Mundo cíclico com veículo
## Descrição do programa

 * Existe um mundo cíclico (uma matriz 60x30) onde possuem 6 fábricas já previamente definidas, onde são inicializados 30 veículo. Sendo 10 caminhões, 10 carros e 10 motos que são derivados de uma classe master e que se movimentam aleatóriamente pelo mundo. 
 * Quando algum objeto passa pela posição de alguma fábrica é criado um novo objeto daquele mesmo tipo, em alguma coordenada aleatória no mapa.
 * O objeto moto movimenta 3 posições em uma iteração, carro 2 e caminhão 1. 
 * Se um objeto caminhão colidir com qualquer outro objeto caminhão, os dois objetos serão excluídos, porém se colidir com com algum objeto carro ou moto ele se manterá no mapa e os objetos carro e moto serão excluídos do mundo. 
 * Se um objeto carro colidir com qualquer  outro objeto carro, os dois objetos serão excluídos, porém se colidir com um objeto moto ele  se manterá no mapa e o objeto moto será excluído do mapa. 
 * Se um objeto moto colidir com qualquer outro objeto moto, os dois objetos serão excluídos, porém se colidir com qualquer outro objeto ele será excluído.
 * Existe uma diferenciação por cores que será exibido. O objeto moto é representado pela cor azul, carro vermelho, caminhão amarelo, as fabricas serão verde e o que estiver em preto são posições livres para movimentação.
 * A execução irá parar quando a quantidade de Motos e Carro forem 0 (zero).

## Como executar o programa

### Se o seu ambiente de execução for alguma destribuição Linux siga os seguintes passos a serem executados no console:

* Clone o repositório;

`$ git clone https://github.com/gferreir/oop_project_world_vehicles.git`

* Navegue até o diretório do projeto

`$ cd oop_project_world_vehicles/`

* Crie um diretório

`$ mkdir projeto_poo`

* Mova todo conteúdo do repositório clonado para este novo diretório que foi criado

`$ mv *.java projeto_poo`

* Compile a classe Main.java

`$ javac -classpath . ./projeto_poo/Main.java`

* Execute o Main

`$ java -classpath . projeto_poo/Main`

Feito isso o resultado do progorama será exibido no console. 

## Considerações importantes

Como o Java não possui meios para limpar o console, existem alguns meios para se fazer isso. Um deles era usar o seguinte método no código:

`Runtime.getRuntime.exec("command");`

Porém para esse comando ser executado junto com o código vai depender de qual ambiente o código está sendo compilado, por exemplo se for em um ambiente Windows o comando será **cls** no lugar da palavra **command**, agora se for um ambiente Linux será **clear**.

Sendo assim optei por fazer um looping **FOR** para pular determinadas linhas onde pode ser verificado na linha **71** da classe **Main.java**. Com isso dependendo da resolução do monitor onde será exibido o console, se faz necessário acrescentar ou decrementar a variável ***i*** do looping **FOR**.

A documentação do programa está na pasta **doc** e a extensão é ***.html***. Sendo assim para visualiza-la, o repositório deverá ser clonado para sua máquina local e abrir o arquivo ***index.html***.

### V 1.2
