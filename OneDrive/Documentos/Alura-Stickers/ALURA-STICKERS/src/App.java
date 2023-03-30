import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // usando endereço alternativo
        // fazer uma conexão HTTP e buscar os top filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json"; 
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();  
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
        String body = response.body();
        
        //extrair só os dados que interessam (titulo,poster,classificação)
        var parser = new JsonParser();
        List<Map<String,String>> ListadeFilmes = parser.parse(body);  

        //exibir e manipular os dados
        for (Map<String,String> filme : ListadeFilmes){
             System.out.println("\u001b[1mTítulo:\u001b[m "+ filme.get("title"));
             System.out.println("\u001b[1mURL da Imagem:\u001b[m "+filme.get("image"));
             double classificacao = Double.parseDouble(filme.get("imDbRating"));
             int numeroTrevo = (int) classificacao;
            for (int n = 1; n <= numeroTrevo; n++){
            System.out.print("🍀");
            }

            System.out.println("\n");

        }      
    }
}
