/***********************************************************************
 * Copyright 2017 Kimio Kuramitsu and ORIGAMI project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***********************************************************************/

package blue.origami.asm;

@SuppressWarnings("serial")
public class OrigamiContinueException extends RuntimeException {
	private boolean hasValue = false;
	private Object value;

	public OrigamiContinueException() {
		super();
	}

	public OrigamiContinueException(Object value) {
		super();
		this.hasValue = true;
		this.value = value;
	}

	public boolean hasValue() {
		return this.hasValue;
	}

	public Object getValue() {
		return this.value;
	}

}
