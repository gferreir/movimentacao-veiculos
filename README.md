# Mundo cíclico com veículo
## Descrição do código

* Existe um mundo cíclico (uma matriz 60x30) onde possuem 6 fábricas já previamente definidas, onde são inicializados 30 veículo. Sendo 10 caminhões, 10 carros e 10 motos que são derivados de uma classe master e que se movimentam aleatóriamente pelo mundo. 
* Quando algum objeto passa pela posição de alguma fábrica é criado um novo objeto daquele mesmo tipo, em alguma coordenada aleatória no mapa. 
 * Se um objeto caminhão colidir com qualquer outro objeto caminhão, os dois objetos serão excluídos, porém se colidir com com algum objeto carro ou moto ele se manterá no mapa e os objetos carro e moto serão excluídos do mundo. 
 * Se um objeto carro colidir com qualquer  outro objeto carro, os dois objetos serão excluídos, porém se colidir com um objeto moto ele  se manterá no mapa e o objeto moto será excluído do mapa. 
 * Se um objeto moto colidir com qualquer outro objeto moto, os dois objetos serão excluídos, porém se colidir com qualquer outro objeto ele será excluído.
 * A execução irá parar quando o ArrayList de Moto e ArrayList de Carro forem 0 (zero).

# Considerações importantes

Como no Java não possui meios para limpar o console, existem alguns meios para se fazer isso. Um deles era usar o seguinte método no código:

`Runtime.getRuntime.exec("command");`

Porém para esse comando ser executado junto com o código vai depender de qual ambiente o código está sendo compilado, por exemplo se for em um ambiente Windows o comando será **cls** no lugar da palavra **command**, agora se for um ambiente Linux será **clear**.

Sendo assim optei por fazer um looping **FOR** para pular determinadas linhas onde pode ser verificado na linha **62** da classe **Main.java**. Com isso dependendo da resolução do monitor onde será exibido o console, se faz necessário acrescentar ou decrementar a variável ***i*** do looping **FOR**.
