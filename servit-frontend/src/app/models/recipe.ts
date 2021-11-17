import {Step} from "./step";
import {Ingredient} from "./ingredient";

export class Recipe {
  id: number;
  name: string;
  timeToPrepare: string;
  ingredients: Array<Ingredient>;
  steps: Array<Step>;
  planned: boolean;
  detailsVisible: boolean = false;
}
