//package com.nadarihi;
//
//import dev.langchain4j.data.embedding.Embedding;
//import dev.langchain4j.model.embedding.EmbeddingModel;
//import dev.langchain4j.model.embedding.onnx.bgesmallenv15.BgeSmallEnV15EmbeddingModel;
//import dev.langchain4j.model.google.genai.GoogleGenAiEmbeddingModel;
//import dev.langchain4j.store.embedding.CosineSimilarity;
//
//import java.time.Duration;
//
//public class Test4Embeddings {
//
//    public static void main(String[] args) {
//        // Modèle intégré (gratuit, entraîné sur l'anglais)
//        EmbeddingModel modeleIntegre = new BgeSmallEnV15EmbeddingModel();
//
//        // Modèle externe de Google
//        EmbeddingModel modeleGoogle = GoogleGenAiEmbeddingModel.builder()
//                .apiKey(System.getenv("GEMINI_API_KEY"))
//                .modelName("gemini-embedding-001")
//                .taskType(GoogleGenAiEmbeddingModel.TaskTypeEnum.SEMANTIC_SIMILARITY)
//                .timeout(Duration.ofSeconds(10))
//                .build();
//
//        String[][] couples = {
//                {"Le chat dort sur le canapé.", "Un chat fait la sieste sur le sofa."},   // similaires
//                {"Il fait très chaud aujourd'hui.", "Il fait très froid aujourd'hui."},   // opposées
//                {"J'aime beaucoup le chocolat.", "Je déteste le chocolat."},              // opposées
//                {"La voiture est rouge.", "Le cours de bourse a chuté hier."},            // sans rapport
//                {"Je mange une pomme.", "Je dévore un fruit."},                           // similaires
//                {"Paris est la capitale de la France.", "Le chien aboie dans le jardin."} // sans rapport
//        };
//
//        System.out.println("Intégré | Google  | Phrases");
//        for (String[] c : couples) {
//            double simIntegre = similarite(modeleIntegre, c[0], c[1]);
//            double simGoogle = similarite(modeleGoogle, c[0], c[1]);
//            System.out.printf("%.4f  | %.4f  | %s  /  %s%n", simIntegre, simGoogle, c[0], c[1]);
//        }
//    }
//
//    static double similarite(EmbeddingModel model, String a, String b) {
//        Embedding e1 = model.embed(a).content();
//        Embedding e2 = model.embed(b).content();
//        return CosineSimilarity.between(e1, e2);
//    }
//}