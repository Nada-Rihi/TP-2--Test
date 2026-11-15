java: package dev.langchain4j.model.embedding.onnx.bgesmallenv15 does not exist

Ton pom.xml est correct : la dépendance est bien là, au bon endroit. L’erreur de build que tu as vue datait probablement d’avant le rechargement Maven. Il faut maintenant vérifier que la synchronisation s’est faite. 

J'avais seulement arrêté le build en cours et j'ai cru que la synchronisation de Maven était terminée. J'ai donc trouvé l'erreur bizarre, puisque mon pom.xml était correct. J'ai alors demandé quelle pouvait en être la raison, et il s'est avéré qu'il suffisait de relancer Maven.