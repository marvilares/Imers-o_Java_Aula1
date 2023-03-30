import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        //leitura da imagem 
        BufferedImage ImagenOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        //cria nova imagem em memoria com transparencia e com tamanho novo
        int largura = ImagenOriginal.getWidth();
        int altura = ImagenOriginal.getHeight();
        int novaaltura = altura + 500;
        BufferedImage novaImagem = new BufferedImage(largura,novaaltura,BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem em memoria
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(ImagenOriginal, 0, 0 , null);

    
        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 64);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaaltura - 200);


        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));   

    }

}




