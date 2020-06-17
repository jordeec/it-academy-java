
import { Propulsor } from './propulsor';

export interface Rocket {
  id: number;
  code: string;
  targetSpeed: number;
  currentSpeed: number;
  maxPropulsors: number;
  propulsors: Propulsor[];
}
