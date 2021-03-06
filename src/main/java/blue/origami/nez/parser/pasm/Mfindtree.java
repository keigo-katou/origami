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

package blue.origami.nez.parser.pasm;

import blue.origami.nez.parser.ParserGrammar.MemoPoint;

public final class Mfindtree extends PAsmInst {
	public final int memoPoint;
	// public final PAsmInst jump;

	public Mfindtree(MemoPoint m, PAsmInst unfound, PAsmInst ret) {
		super(unfound);
		this.memoPoint = m.id;
		assert (ret instanceof Iret);
		// this.jump = ret;
	}

	@Override
	public PAsmInst exec(PAsmContext px) throws PAsmTerminationException {
		switch (lookupMemo3(px, this.memoPoint)) {
		case PAsmAPI.NotFound:
			return this.next;
		case PAsmAPI.SuccFound:
			return popRet(px);
		// return this.jump;
		default:
			return raiseFail(px);
		}
	}

}