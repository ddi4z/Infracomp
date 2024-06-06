package ParcialConcurrencia.Filosofos;


/* 
    Propuesto por Edsger Dijkstra en 1965
    Cinco filósofos se sientan alrededor de una mesa y pasan su vida cenando y pensando.
    Cada filósofo tiene un plato de fideos y un palito a la izquierda de su plato. Para comer los fideos son necesarios dos palitos y cada filósofo sólo puede tomar el que están a su izquierda el que está a su derecha
    Si un filósofo toma un palito y el otro está ocupado, se quedará esperando, con el palito en la mano, hasta que pueda tomar el segundo y así poder comer.
    Si dos filósofos adyacentes intentan tomar el mismo palito a una vez, se produce una condición de carrera: ambos compiten por tomar el mismo palito, y uno de ellos se queda sin comer
    Si todos los filósofos toman el palito que está a su derecha al mismo tiempo, entonces todos se quedarán esperando eternamente, porque alguien debe liberar el palito que les falta. Nadie lo hará porque todos se encuentran en la misma situación. Entonces los filósofos se morirán de hambre.
    El problema consiste en encontrar un algoritmo que permita que los filósofos nunca se mueran de hambre
    @author: ddi4z
*/
public class Principal{


    public static void main(String[] args){
        Mesa mesa = new Mesa();
        for(int i = 0; i<5; i++){
            new Filosofo(i, mesa).start();
        }

    }
}