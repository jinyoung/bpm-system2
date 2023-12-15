import processDefinitionYaml from "./processDefinition-openapi.yaml";
import instanceYaml from "./instance-openapi.yaml";
import taskListYaml from "./taskList-openapi.yaml";
import chatroomYaml from "./chatroom-openapi.yaml";
import YAML from "json2yaml";

let apiSpec = "";

let processDefinitionSpec = YAML.stringify(processDefinitionYaml);
apiSpec += processDefinitionSpec;

let instanceSpec = YAML.stringify(instanceYaml);
apiSpec += instanceSpec;

let taskListSpec = YAML.stringify(taskListYaml);
apiSpec += taskListSpec;

let chatroomSpec = YAML.stringify(chatroomYaml);
apiSpec += chatroomSpec;


export default apiSpec;